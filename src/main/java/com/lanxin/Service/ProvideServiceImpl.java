package com.lanxin.Service;

import com.lanxin.Commons.Result;
import com.lanxin.Dao.UsersMapper;
import com.lanxin.bean.Users;
import com.lanxin.bean.UsersExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fjw on 2019/5/9.
 */
@Service
public class ProvideServiceImpl implements  ProvideService {

   @Autowired
   private UsersMapper usersMapper;
    @Override
    public Result selectallUser() {

      List<Users> lists= usersMapper.selectByExample(new UsersExample());
        return  Result.ok(lists);
    }
}
