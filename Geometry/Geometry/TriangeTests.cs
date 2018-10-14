using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;

namespace Geometry
{
    [TestFixture]
    public class TriangeTests
    {

        [Test]
        public void IsExist_TriangleExist_ReturnTrue()
        {
            double x = 5;
            double y = 4;
            double z = 6;

            bool isExist = Triangle.IsExist(x, y, z);
            Assert.AreEqual(true, isExist);
        }

        [Test]
        public void IsExist_SumOfTwoSidesAreEqualRemainingSide_ReturnFalse()
        {
            double x = 1;
            double y = 1;
            double z = 2;

            bool isExist = Triangle.IsExist(x, y, z);
            Assert.AreEqual(false, isExist);
        }

        [Test]
        public void IsExist_SumOfTwoSidesAreLessThanRemainingSide_ReturnFalse()
        {
            double x = 2;
            double y = 1;
            double z = 8;

            bool isExist = Triangle.IsExist(x, y, z);
            Assert.AreEqual(false, isExist);
        }

        [Test]
        public void IsExist_AllSumsAreVeryLessThanRemainingSide_ReturnFalse()
        {
            double x = 9;
            double y = 10;
            double z = 9_999_999;

            bool isExist = Triangle.IsExist(x, y, z);
            Assert.AreEqual(false, isExist);
        }

        [Test]
        public void IsExist_ZeroFirstSideSize_ThrowArgumentException()
        {
            double x = 0;
            double y = 1;
            double z = 2;

            Assert.Catch<ArgumentException>(() => Triangle.IsExist(x, y, z));
        }

        [Test]
        public void IsExist_ZeroSecondSideSize_ThrowArgumentException()
        {
            double x = 3;
            double y = 0;
            double z = 2;

            Assert.Catch<ArgumentException>(() => Triangle.IsExist(x, y, z));
        }

        [Test]
        public void IsExist_ZeroThirdSideSize_ThrowArgumentException()
        {
            double x = 3;
            double y = 6;
            double z = 0;

            Assert.Catch<ArgumentException>(() => Triangle.IsExist(x, y, z));
        }

        [Test]
        public void IsExist_NegativeFirstSideSize_ThrowArgumentException()
        {
            double x = -1;
            double y = 4;
            double z = 5;

            Assert.Catch<ArgumentException>(() => Triangle.IsExist(x, y, z));
        }

        [Test]
        public void IsExist_NegativeSecondSideSize_ThrowArgumentException()
        {
            double x = 1;
            double y = -4;
            double z = 5;

            Assert.Catch<ArgumentException>(() => Triangle.IsExist(x, y, z));
        }

        [Test]
        public void IsExist_NegativeThirdSideSize_ThrowArgumentException()
        {
            double x = 1;
            double y = 4;
            double z = -5;

            Assert.Catch<ArgumentException>(() => Triangle.IsExist(x, y, z));
        }

    }
}
