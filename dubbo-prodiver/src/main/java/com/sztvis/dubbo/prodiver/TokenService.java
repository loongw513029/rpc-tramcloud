package com.sztvis.dubbo.prodiver;

import com.alibaba.dubbo.config.annotation.Service;
import com.sztvis.domain.domain.V3TokenInfo;
import com.sztvis.dubbo.ITokenService;
import com.sztvis.dubbo.prodiver.mapper.TokenMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/2/7 下午5:10
 */
@Service(version = "1.0.0")
public class TokenService implements ITokenService {
    @Autowired
    private TokenMapper tokenMapper;
    @Override
    public void insertTokenInfo(V3TokenInfo tokenInfo) {
        this.tokenMapper.insertTokenInfo(tokenInfo);
    }

    @Override
    public V3TokenInfo getTokenInfo(String departmentcode) {
        return this.tokenMapper.getTokenInfo(departmentcode);
    }

    @Override
    public void updateToken(String departmentcode, String accesstoken, String refreshtoken) {
        this.tokenMapper.UpdateAccessToken(accesstoken,departmentcode,refreshtoken);
    }
}
