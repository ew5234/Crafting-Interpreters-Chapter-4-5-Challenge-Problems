class Shape a where
  area :: a -> Double
  perimeter :: a -> Double
  describe :: a -> String

data Circle = Circle Double

instance Shape Circle where
  area (Circle r) = pi * r * r
  perimeter (Circle r) = 2 * pi * r
  describe (Circle r) = "Circle with radius " ++ show r

data Rectangle = Rectangle Double Double

instance Shape Rectangle where
  area (Rectangle l h) = l * h
  perimeter (Rectangle l h) = (l + h ) * 2
  describe (Rectangle l h) = "Rectangle with length " ++ show l ++ " and height " ++ show h

main :: IO ()
main = do
  let c1 = Circle 5
  let r1 = Rectangle 2 3
  let c2 = Circle 2

  print (describe c1)
  print (area c1)
  print (perimeter c1)

  print (describe r1)
  print (area r1)
  print (perimeter r1)

  print (describe c2)
  print (area c2)
  print (perimeter c2)
