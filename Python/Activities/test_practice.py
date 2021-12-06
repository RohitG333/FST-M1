	
import pytest
import math
@pytest.mark.sqrt 
def test_sqrt():
   num = 25
   assert math.sqrt(num) == 5

@pytest.mark.square
def testsquare():
   num = 7
   assert num*num == 49

@pytest.mark.equality 
def testequality():
   assert 10 == 11