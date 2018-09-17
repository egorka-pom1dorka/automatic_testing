using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestTask
{
    static class StudentsMarkCalculator
    {

        public static double GetAverageMarkByStudents(List<Student> students)
        {
            double avgSum = 0;
            foreach (var student in students)
            {
                avgSum += student.GetAverageMark();
            }
            return avgSum / students.Count();
        }

    }
}
