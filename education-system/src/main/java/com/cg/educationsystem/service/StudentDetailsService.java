package com.cg.educationsystem.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.educationsystem.dao.IStudentDetailsRepository;
import com.cg.educationsystem.entity.StudentDetails;

@Service
public class StudentDetailsService implements IStudentDetailsService {
	@Autowired
	IStudentDetailsRepository studentRepository;

	@Override
	public List<StudentDetails> addStudentDetails(StudentDetails student) {
		 studentRepository.save(student);
		 return studentRepository.findAll();
	}

	@Override
	public List<StudentDetails> getAllStudentDetails() {
		return studentRepository.findAll();
	}

	@Override
	public StudentDetails getStudentDetailsById(int studentId) {
		return studentRepository.getStudentDetailsById(studentId);
	}

	@Override
	public List<StudentDetails> deleteStudentDetails(int studentId) {
		StudentDetails student=studentRepository.getStudentDetailsById(studentId);
		if(student!=null) {
			studentRepository.deleteById(studentId);
			return studentRepository.findAll();
		}
		return Collections.emptyList();
	}

	@Override
	public List<StudentDetails> updateStudentDetails(StudentDetails studentDetails) {
		StudentDetails student = studentRepository.getStudentDetailsById(studentDetails.getStudentId());
		if(student!=null) {
			student.setFirstName(studentDetails.getFirstName());
			student.setLastName(studentDetails.getLastName());
			student.setDateOfBirth(studentDetails.getDateOfBirth());
			student.setPhoneNumber(studentDetails.getPhoneNumber());
			student.setStudentEmailId(studentDetails.getStudentEmailId());
			studentRepository.save(student);
			return studentRepository.findAll();
		}
		return Collections.emptyList();
	}
}
	
