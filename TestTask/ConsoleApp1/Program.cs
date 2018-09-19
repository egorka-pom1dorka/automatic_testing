using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace TestTask
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Student> students = new List<Student>();
            bool continueProgramm = true;

            while (continueProgramm)
            {
                Console.WriteLine(Menu());
                int number = getMenuNumber();
                switch (number) {
                    case 1:
                        var temp = IOStudent.InputStudents();
                        foreach (var student in temp)
                        {
                            students.Add(student);
                        }
                        break;

                    case 2:
                        IOStudent.OutputStudents(students);
                        break;

                    case 3:
                        Console.WriteLine($"Input index of student from 0 to {students.Count() - 1}");
                        int index = -1;
                        while (index < 0 || index > students.Count() - 1)
                        {
                            int.TryParse(Console.ReadLine(), out index);
                        }
                        var mark = students.ElementAt(index).GetAverageMark();
                        Console.WriteLine(mark);
                        break;

                    case 4:
                        var avg = StudentsMarkCalculator.GetAverageMarkByStudents(students);
                        Console.WriteLine(avg);
                        break;

                    case 5:
                        Console.Clear();
                        break;

                    case 6:
                        continueProgramm = false;
                        break;
                }
            }

            Console.WriteLine("Good bye!");
            Thread.Sleep(1000);
        }

        static string Menu()
        {
            return "Choose action\n" + 
                "1) Add students.\n" + 
                "2) Show Students.\n" + 
                "3) Show average mark for student.\n" + 
                "4) Show average marks for all students.\n" +
                "5) Clear console.\n" +
                "6) Stop programm";
        }

        static int getMenuNumber()
        {
            int number = 0;
            while (number < 1 || number > 6)
            {
                int.TryParse(Console.ReadLine(), out number);
            }
            return number;
        }

    }
}
