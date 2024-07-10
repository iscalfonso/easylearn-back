package com.easylearn.unir.services.implementations;

import com.easylearn.unir.services.GetGrades;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GetGradesImpl implements GetGrades {

    @Override
    public double grades(double a, double b) {

        return (a+b)/2;
    }

    @Override
    public int deadline(Date a, Date b) {

        long startTime = a.getTime();
        long endTime = b.getTime();
        long diffTime = endTime - startTime;
        long diffDays = diffTime / (1000 * 60 * 60 * 24);

        return (int)diffDays;
    }
}
