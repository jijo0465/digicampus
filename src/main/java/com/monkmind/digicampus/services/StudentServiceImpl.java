/*created by:shijina
 * created on: 17/05/2020
 * 
 */


package com.monkmind.digicampus.services;

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
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

//import org.apache.juli.logging.Log;
//import org.hibernate.annotations.common.util.impl.Log;
//import org.apache.commons.logging.Log;
//import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ParentRepository parentRepository;
    private final RegisterCommandToStudent registerCommandToStudent;
    private final StudentToRegisterCommand studentToRegisterCommand;
    private final UserService userService;
    @Override
    public Student addStudent(Student student) {
//        addParent(student.getParent());
		System.out.println(student.getParent().getPhone());
		Parent p = parentRepository.findByPhone(student.getParent().getPhone()).orElse(null);
		if(p!=null){
			student.setParent(p);
		}
		
        return studentRepository.save(student);
    }

    public void addParent(Parent parent){
        Parent p = parentRepository.findByPhone(parent.getPhone()).orElse(null);
        if(p==null){
			parentRepository.save(parent);
			
		}

    }

    @Override
	public Student getStudentByStudentId(String student) {
		// TODO Auto-generated method stub
		return studentRepository.findByStudentId(student).orElse(null);
	}

	/*@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
	}
	*/
	

	@Override
	public Student get(long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get();
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
		Student savedStudent=studentRepository.save(detachedStudent);
		User user=new User();
		user.setLoginId(savedStudent.getParent().getParentId());
		long password = (long) Math.floor(Math.random() * 90000L) + 1000L;
		user.setPassword(Long.toString(password));
		user.setUsertype(UserType.PARENT);
		User saveduser=userService.saveUser(user);
		System.out.println(user.getLoginId());
		//log.debug("saved studentid :"+ savedStudent.getId());
		return studentToRegisterCommand.convert(savedStudent) ;
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
}
