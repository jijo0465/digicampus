package com.monkmind.digicampus.services;

import com.monkmind.digicampus.models.Teacher;

public interface TeacherService {

	//public Teacher addTeacher(Teacher teacher);
	public void save(Teacher teacher);
    public Teacher getTeacherByTeacherId(String string);
}
