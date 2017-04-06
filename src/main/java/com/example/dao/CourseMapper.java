package com.example.dao;

import java.util.List;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;

import com.example.model.CourseModel;
import com.example.model.StudentModel;

@Mapper
public interface CourseMapper {
	
	@Select("select id_course, nama, sks from course WHERE id_course= #{idCourse}")
    @Results(value={
    		@Result(property="idCourse", column="id_course"),
    		@Result(property="nama", column="nama"),
    		@Result(property="sks", column="sks"),
    		@Result(property="students", column="id_course",
    		javaType = List.class, many=@Many(select="selectStudents"))
    })
	CourseModel selectCourse(@Param("idCourse") String idCourse) ;
	

	@Select("select student.npm, name, gpa " +
    		"from studentcourse join student " +
    		"on studentcourse.npm = student.npm " +
    		"where studentcourse.id_course= #{idCourse}")
    List<StudentModel> selectStudents (@Param("idCourse") String idCourse);

}
