package com.nf147.platform.service.impl;

import com.nf147.platform.dao.GeCommentMapper;
import com.nf147.platform.entity.GeComment;
import com.nf147.platform.service.GeCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 梁
 * // TODO: 2019/2/25
 * 评论
 */
@Service
public class GeCommentServiceImpl implements GeCommentService {
    @Autowired
    private GeCommentMapper geCommentMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return geCommentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GeComment record) {
        return geCommentMapper.insert(record);
    }

    @Override
    public GeComment selectByPrimaryKey(Integer id) {
        return geCommentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<GeComment> selectAll() {
        return geCommentMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(GeComment record) {
        return geCommentMapper.updateByPrimaryKey(record);
    }
}
