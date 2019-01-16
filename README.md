# scala212-category-theory-either-bifunctor
_Reference_: https://bartoszmilewski.com/2015/02/03/functoriality/

# definition
Bifunctor is a two-argument functor (domain is product category).

The easiest way to think about bifunctors is that they are 
functors in both arguments. So instead of translating 
functorial laws - associativity and identity preservation - 
from functors to bifunctors, it’s enough to check them 
separately for each argument.

**As far as we stay only in Cats category (functors are morphisms)
the above statement is true. But not in general:** 
https://ncatlab.org/nlab/show/funny+tensor+product#separate_functoriality

```
class Bifunctor f where
    bimap :: (a -> c) -> (b -> d) -> f a b -> f c d
    bimap g h = first g . second h
    first :: (a -> c) -> f a b -> f c b
    first g = bimap g id
    second :: (b -> d) -> f a b -> f a d
    second = bimap id
```

* we can specify `bimap` in terms of `first` and `second`
    ```
    bimap g h = first g . second h
    ```
* we can specify `first` and `second` in terms of `bimap`
    ```
    first :: (a -> c) -> f a b -> f c b
    second :: (b -> d) -> f a b -> f a d
    ```
* we can specify three of them, but we have to assure that
they are related in that way

# project description
We provide implementation of `bimap` for `Either`:
```
def bimap[X1, Y1](first: X => X1, second: Y => Y1): Either[X1, Y1] = either match {
  case Left(x) => Left(first(x))
  case Right(y) => Right(second(y))
}
```
and derived implementations of `first` and `second`
```
def first[X, X1, Y](f: Function[X, X1]) = bimap(f, identity)

def second[X, Y, Y1](f: Function[Y, Y1]) = bimap(identity, f)
```