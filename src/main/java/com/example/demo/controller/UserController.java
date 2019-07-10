package com.example.demo.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.demo.base.Consants;
import com.example.demo.base.ServiceException;
import com.example.demo.dto.GeneralResponseDto;
import com.example.demo.entity.User;
import com.example.demo.serviceImp.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author: ChangYu
 * @Version 1.0
 */
@Api(description = "用户相关接口")
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	private UserService userService;


	@ApiOperation(value="登录")
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public GeneralResponseDto login(@RequestParam(value = "username") String username,
									@RequestParam(value = "password") String password, HttpServletRequest request) {
		return userService.login(request, username, password);
	}

	@ApiOperation(value="注销")
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public GeneralResponseDto logout() {
		Subject subject = SecurityUtils.getSubject();
		userService.logout(subject);
		subject.logout();
		return GeneralResponseDto.addSuccess();
	}


	@ApiOperation(value="保存用户")
	@RequiresRoles("admin")
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public GeneralResponseDto save(@RequestBody User user) {
		userService.doSaveUser(user);
		return GeneralResponseDto.addSuccess();
	}

	@ApiOperation(value="删除用户")
	@RequiresRoles("admin")
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public GeneralResponseDto delete(int id) {
		userService.doDelete(id);
		return GeneralResponseDto.addSuccess();

	}


	@ApiOperation(value="查询")
	@RequestMapping(value = "/findUsers",method = RequestMethod.GET)
	public GeneralResponseDto findUsers(@RequestParam(value = "username",required = false)String username,
										@RequestParam(value = "phone",required = false)String phone,
										@RequestParam(value = "realname",required = false)String realname,
										@RequestParam(value = "status",required = false)String status,
										@RequestParam(value = "email",required = false)String email,
										@RequestParam(value = "pageNo",required = false,defaultValue = "1")int pageNo,
										@RequestParam(value = "pageSize",required = false,defaultValue = "999")int pageSize
										) {
		return GeneralResponseDto.addSuccess(userService.findAllUser(username,phone,realname,status,email,pageNo,pageSize));
	}

	/**
	 * excel模板下载
	 *
	 * @param response
	 * @param filename
	 * @throws IOException
	 */
	@ApiOperation(value = "模板下载", produces = "application/octet-stream")
	@RequestMapping(value = "/downloadTemplate", method = RequestMethod.GET)
	public void downloadTempate(HttpServletResponse response, @RequestParam(value = "filename") String filename) throws IOException {
		String path = Consants.TEMPATE_PATH_PREFIX + String.format("%s.xlsx", filename);
		boolean exist = FileUtil.exist(path);
		if (!exist) {
			throw new ServiceException("文件模板不存在");
		}
		ExcelWriter writer = ExcelUtil.getWriter(path);
		response.setContentType("application/octet-stream;charset=utf-8");
		response.setHeader("Content-Disposition", String.format("attachment;filename=%s.xlsx", filename));
		OutputStream out = response.getOutputStream();
		writer.flush(out);
		writer.close();
		out.close();
	}
}