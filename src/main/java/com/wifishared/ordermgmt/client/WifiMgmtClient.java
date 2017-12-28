package com.wifishared.ordermgmt.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.wifishared.common.data.otd.hotspot.HotSpotRspBody;
import com.wifishared.common.framework.resultobj.GeneralContentResult;
import io.swagger.annotations.ApiOperation;

@FeignClient(url = "http://127.0.0.1:9993",name = "wifimgmt")
public interface WifiMgmtClient {

	@ApiOperation(value = "查询热点信息")
	@RequestMapping(value = "/auth/v1/hotspots/{hotspotId}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public GeneralContentResult<HotSpotRspBody> findHotSpot(
			@PathVariable("hotspotId") String hotspotId) ;
	
}
