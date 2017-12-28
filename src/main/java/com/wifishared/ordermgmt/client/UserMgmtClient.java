package com.wifishared.ordermgmt.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.wifishared.common.data.otd.user.UserDeviceRsp;
import com.wifishared.common.framework.resultobj.GeneralContentResult;
import io.swagger.annotations.ApiOperation;

@FeignClient(url = "http://127.0.0.1:9991",name = "usermgmt")
public interface UserMgmtClient {

	@ApiOperation(value = "查询用户的设备")
	@RequestMapping(value = "/auth/v1/users/{userId}/devices", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public GeneralContentResult<List<UserDeviceRsp>> queryDevices(@PathVariable("userId") String userId);
	
}
