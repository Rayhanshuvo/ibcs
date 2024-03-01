package com.ibcs.demo.service;

import com.ibcs.demo.entity.Grade;
import com.ibcs.demo.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicSalaryService {
    private static final double HOUSE_RENT_PERCENTAGE = 0.20;
    private static final double MEDICAL_ALLOWANCE_PERCENTAGE = 0.15;
    private static final double BASIC_SALARY_INCREMENT = 5000.0;
    @Autowired
    private GradeRepository gradeRepository;

    public void setBasicSalaryForGradeSix(double basicSalary) {
        double houseRent = basicSalary * HOUSE_RENT_PERCENTAGE;
        double medicalAllowance = basicSalary * MEDICAL_ALLOWANCE_PERCENTAGE;
        double totalSalary = basicSalary + houseRent + medicalAllowance;

        Grade gradeSix = getOrCreateGrade("6");
        setGradeDetails(gradeSix, basicSalary, houseRent, medicalAllowance, totalSalary);
        gradeRepository.save(gradeSix);

        updateBasicSalariesFromGradeSix(basicSalary);
    }

    private void updateBasicSalariesFromGradeSix(double basicSalary) {
        double previousBasicSalary = basicSalary + BASIC_SALARY_INCREMENT;
        for (int i = 5; i >= 1; i--) {
            Grade grade = getOrCreateGrade(String.valueOf(i));
            setGradeDetails(grade, previousBasicSalary, previousBasicSalary * HOUSE_RENT_PERCENTAGE,
                    previousBasicSalary * MEDICAL_ALLOWANCE_PERCENTAGE,
                    previousBasicSalary + (previousBasicSalary * HOUSE_RENT_PERCENTAGE)
                            + (previousBasicSalary * MEDICAL_ALLOWANCE_PERCENTAGE));
            gradeRepository.save(grade);
            previousBasicSalary += BASIC_SALARY_INCREMENT;
        }
    }

    private void setGradeDetails(Grade grade, double basicSalary, double houseRent, double medicalAllowance,
                                 double totalSalary) {
        grade.setBasicSalary(basicSalary);
        grade.setHouseRent(houseRent);
        grade.setMedicalAllowance(medicalAllowance);
        grade.setTotalSalary(totalSalary);
    }

    private Grade getOrCreateGrade(String gradeNo) {
        Grade grade = gradeRepository.findByGradeNo(gradeNo);
        if (grade == null) {
            grade = new Grade();
            grade.setGradeNo(gradeNo);
        }
        return grade;
}
}
