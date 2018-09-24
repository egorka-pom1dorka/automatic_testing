using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestTask
{
    class Student
    {

        private string name;
        private List<int> marks;

        public Student(string studname)
        {
            name = studname;
            marks = new List<int>();
        }

        public Student(string studname, int[] studmarks)
        {
            name = studname;
            marks = new List<int>();
            foreach (var mark in studmarks)
            {
                marks.Add(mark);
            }
        }

        public string GetName()
        {
            return name;
        }

        public List<int> GetMarks()
        {
            return marks;
        }

        public Student AddMark(int mark)
        {
            marks.Add(mark);
            return this;
        }

        public Student RemoveMark(int index)
        {
            marks.RemoveAt(index);
            return this;
        }

        public double GetAverageMark()
        {
            return marks.Average();
        }

        public void print()
        {
            string obj = $"(\n name: {name},\n marks: [{string.Join(",", marks)}]\n)";
            Console.WriteLine(obj);
        }

    }
}
