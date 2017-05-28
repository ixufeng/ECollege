package com.xf.college.api.controller;

import com.xf.college.dao.CourseDao;
import com.xf.college.model.Course;
import com.xf.college.model.apiwrapper.APIResult;
import com.xf.college.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Created by xufeng on 2017/4/24.
 */
@RestController
@RequestMapping("/course")
public class CourseController extends BaseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseDao courseDao;

    @RequestMapping("/all")
    public APIResult getCourseList(){
        return asSuccess(courseService.getCourseList());
    }


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public APIResult addCourse(
            @RequestParam("courseName") String courseName,
            @RequestParam("courseId") String courseId
    ) {

        if (Objects.equals(courseId,null) || Objects.equals(courseName,null)) {
            return asError("请补全信息");
        }
        Course course = new Course(courseId,courseName);
        int result = courseDao.add(course);
        if (result > 0 ) {
            return asSuccess("添加成功");
        }
        return asError("添加失败");
    }

    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public APIResult deleteCourse(
            @RequestParam("courseId") String courseId
    ) {
        int result  = courseDao.delete(courseId);
        if (result > 0) {
            return asSuccess("删除成功");
        }
        return asError("删除失败");
    }
}
