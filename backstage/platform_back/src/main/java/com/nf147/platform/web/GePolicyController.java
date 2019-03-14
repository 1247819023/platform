package com.nf147.platform.web;

import com.nf147.platform.entity.GePolicy;
import com.nf147.platform.service.impl.GePolicyServiceImpl;
import com.nf147.platform.util.response.Constants;
import com.nf147.platform.util.response.JSONResponse;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张东明
 * @info 政策
 * @date 20192/21
 */
@RestController
public class GePolicyController {

    @Autowired
    private GePolicyServiceImpl gePolicyService;

    /**
     * /policy/insert 向政策结构表插入数据
     * @remark √
     */
    @PostMapping("/policy/insert")
    public JSONResponse insertDetail(@RequestBody GePolicy gePolicy) {
        try {
            if (gePolicy != null) {
                int result = gePolicyService.insert(gePolicy);
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

    /**
     * @author lgj
     * @info 修改政策收藏数
     * @// TODO: 2019/03/08
     */
    @PostMapping("/policy/updateFavor")
    public JSONResponse updateFavor(Integer id){
        try {
            if (id != null) {
                int result = gePolicyService.updateByFavor(id);
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

    /**
     * @author lgj
     * @info 修改政策评论数
     * @// TODO: 2019/03/08
     */
    @PostMapping("/policy/updateComment")
    public JSONResponse updateComment(Integer id){
        try {
            if (id != null) {
                int result = gePolicyService.updateByComment(id);
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
