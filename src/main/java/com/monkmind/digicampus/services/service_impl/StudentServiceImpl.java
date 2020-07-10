/*created by:shijina
 * created on: 17/05/2020
 * 
 */


package com.monkmind.digicampus.services.service_impl;

import com.monkmind.digicampus.command.RegisterCommand;
import com.monkmind.digicampus.converters.RegisterCommandToStudent;
import com.monkmind.digicampus.converters.StudentToRegisterCommand;
import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.models.Parent;

import com.monkmind.digicampus.models.Student;
import com.monkmind.digicampus.models.User;
import com.monkmind.digicampus.models.UserType;
import com.monkmind.digicampus.repositories.ParentRepository;
import com.monkmind.digicampus.repositories.StudentRepository;
import com.monkmind.digicampus.services.StudentService;
import com.monkmind.digicampus.services.UserService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

//import org.apache.juli.logging.Log;
//import org.hibernate.annotations.common.util.impl.Log;
//import org.apache.commons.logging.Log;
//import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ParentRepository parentRepository;
    private final RegisterCommandToStudent registerCommandToStudent;
    private final StudentToRegisterCommand studentToRegisterCommand;
    private final UserService userService;

    @Override
	public Student getStudentByStudentId(String student) {
		// TODO Auto-generated method stub
		return studentRepository.findByStudentId(student).orElse(null);
	}

    @Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
	}

	@Override
	public List<Student> listAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}

	@Override
	@Transactional
	public RegisterCommand saveRegisterCommand(RegisterCommand command) {
		// TODO Auto-generated method stub
		Student detachedStudent=registerCommandToStudent.convert(command);
		Parent p = parentRepository.findByPhone(detachedStudent.getParent().getPhone()).orElse(null);
		if(p!=null){
			detachedStudent.setParent(p);
		}
		long parentid = (long) Math.floor(Math.random() * 9000000L) + 100000L;
		detachedStudent.getParent().setParentId(Long.toString(parentid));
		Student savedStudent=studentRepository.save(detachedStudent);
		User user=new User();
		user.setLoginId(savedStudent.getParent().getParentId());
		long password = (long) Math.floor(Math.random() * 90000L) + 1000L;
		user.setPassword(Long.toString(password));
		user.setUsertype(UserType.PARENT);
		userService.saveUser(user);
		User studentuser=new User();
		studentuser.setLoginId(savedStudent.getStudentId());
		studentuser.setPassword(Long.toString(password));
		studentuser.setUsertype(UserType.STUDENT);
		userService.saveUser(studentuser);
		return studentToRegisterCommand.convert(savedStudent) ;
	}

	@Override
	@Transactional
	public RegisterCommand updateRegisterCommand(RegisterCommand command){
    	Student student=registerCommandToStudent.convert(command);
    	Student saveStudent=studentRepository.save(student);
    	return studentToRegisterCommand.convert(saveStudent);
	}

   @Transactional
	@Override
	public RegisterCommand findCommandById(long l) {
		// TODO Auto-generated method stub
		return studentToRegisterCommand.convert(findById(l));
	}

	@Override
	public Student findById(long l) {
		// TODO Auto-generated method stub
		Optional<Student> studentoptional=studentRepository.findById(l);
		return studentoptional.get();
	}
	public List<Student> findByGradeid(Grade grade){
		return studentRepository.findByGrade(grade);
	}

	

	@Override
	public RegisterCommand getStudentByadmno(String student) {
		// TODO Auto-generated method stub
	 Optional<RegisterCommand> studentoptional=studentRepository.findStudentByStudentId(student);
	 return studentoptional.get();
	}

	@Override
	public List<Student> listAll(String keyword) {
		// TODO Auto-generated method stub
		if (keyword != null||keyword !=" ") {
            return studentRepository.search(keyword);
        }
		else{
			return studentRepository.findAll();
		}
	}
	@Override
	public void isDelete(Long id){
    	Optional<Student> student=studentRepository.findById(id);
    	student.get().setIsDelete(Boolean.TRUE);
    	studentRepository.save(student.get());
	}
}
