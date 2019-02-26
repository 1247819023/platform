package com.nf147.platform.web;

import com.nf147.platform.entity.GeEnterpriseNature;
import com.nf147.platform.service.GeEnterpriseNatureService;
import com.nf147.platform.util.response.Constants;
import com.nf147.platform.util.response.JSONResponse;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 梁光健
 * @info 企业性质
 * @// TODO: 2019/02/26
 */
@RestController
public class GeEnterpriseNatureController {
    @Autowired
    private GeEnterpriseNatureService geEnterpriseNatureService;

    /**
     * 添加企业性质表数据
     * @author 梁光健
     * @// TODO: 2019/02/26
     * */
    @PostMapping("/nature/insert")
    public JSONResponse insertNature(@RequestBody GeEnterpriseNature geEnterpriseNature) {
        try {
            if (geEnterpriseNature != null) {
                int result = geEnterpriseNatureService.insert(geEnterpriseNature);
                if (result > 0) {
                    return  JSONResponse.OK(Constants.SUCCESS_200,result);
                }
            }
        } catch (MyBatisSystemException ex) {
            return JSONResponse.ERROR(Constants.ERROR_500,ex.getMessage());
        } catch (Exception ex) {
            return JSONResponse.ERROR(Constants.ERROR_408,ex.getMessage());
        }
        return null;
    }
}
