using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Geometry
{
    public class Triangle
    {
        public static bool IsExist(double x, double y, double z)
        {
            if (x <= 0 || y <= 0 || z <= 0)
                throw new ArgumentException("Sizes of triangle sides must be natural positive numbers");

            return x + y > z && x + z > y && y + z > x;
        }
    }
}
