using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestTask
{
    static class IOStudent
    {
        public static Student InputStudent()
        {
            Console.WriteLine("Input student's name");
            string name = Console.In.ReadLine();

            Console.WriteLine("Input student's marks separeted by commas");
            string[] marksArr = Console.In.ReadLine().Split(',');
            int[] marks = new int[marksArr.Length];

            for (int i = 0; i < marksArr.Length; i++)
            {
                int mark;
                int.TryParse(marksArr[i], out mark);
                if (mark >= 0 && mark <= 10)
                {
                    marks[i] = mark;
                }
            }

            return new Student(name, marks);
        }

        public static List<Student> InputStudents()
        {
            var students = new List<Student>();
            while (true)
            {
                Console.WriteLine("Create new object? y/n");
                if (Console.ReadLine().StartsWith("y"))
                {
                    students.Add(InputStudent());
                }
                else
                {
                    break;
                }
            }
            return students;
        }

        public static void OutputStudent(Student student)
        {
            student.print();
        }

        public static void OutputStudents(List<Student> students)
        {
            foreach (var student in students)
            {
                OutputStudent(student);
            }
        }

    }

}
