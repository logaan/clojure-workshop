Workshop Cheatsheet
===================

Control flow
------------

- [if](http://clojure.org/special_forms#if) Standard if statement.
- [and](http://clojuredocs.org/clojure_core/clojure.core/and) Returns true if
  all arguments to it are true.
- [or](http://clojuredocs.org/clojure_core/clojure.core/or) Returns true if any
  arguments to it are true.
- [for](http://clojuredocs.org/clojure_core/clojure.core/for) Looping
  structure. A single for can represent many nested loops.
- [cond](http://clojuredocs.org/clojure_core/clojure.core/cond) Case statement.

Collections
-----------

- [reduce](http://clojuredocs.org/clojure_core/clojure.core/reduce) Will run a
  function over a collection. The function will be passed the result of the
  last function call and each item in the collection.
- [filter](http://clojuredocs.org/clojure_core/clojure.core/filter) Takes test
  function and a collection. Returns a new collection with only the items from
  the first collection that caused the test to pass.
- [map](http://clojuredocs.org/clojure_core/clojure.core/map) Takes a function
  and a collection. Returns a new collection with the result of running the
  function over each item in the collection. Be careful. It is lazy.
- [mapv](http://clojure.github.com/clojure/clojure.core-api.html#clojure.core/mapv)
  Like map but not lazy. Do not use with infinite sequences.
- [concat](http://clojuredocs.org/clojure_core/clojure.core/concat) Joins two
  or more sequences.
- [set](http://clojuredocs.org/clojure_core/clojure.core/set) Turns a sequence
  into a set.
- [first](http://clojuredocs.org/clojure_core/clojure.core/first) Returns first
  item of a sequence.
- [rest](http://clojuredocs.org/clojure_core/clojure.core/rest) Returns all but
  the first item of a sequence.
- [take](http://clojuredocs.org/clojure_core/clojure.core/take) Pulls the first
  n items out of a sequence.
- [take-while](http://clojuredocs.org/clojure_core/clojure.core/take-while)
  Pulls items out of a sequence until the test function returns false. No
  further items will be checked.
- [range](http://clojuredocs.org/clojure_core/clojure.core/range) Creates a new
  sequence of numbers. Can be given a lower bound, upper bound and amount to
  increment by.
- [iterate](http://clojuredocs.org/clojure_core/clojure.core/iterate) Creates a
  sequence by running a function over a value. Then a function over the return
  value of the first call, and so on.

Predicates
----------

- [=](http://clojuredocs.org/clojure_core/clojure.core/=) Equality check.
- [+](http://clojuredocs.org/clojure_core/clojure.core/+) Addition.
- [-](http://clojuredocs.org/clojure_core/clojure.core/-) Subtraction.
- [>](http://clojuredocs.org/clojure_core/clojure.core/>) Greater than.
- [<](http://clojuredocs.org/clojure_core/clojure.core/<) Less than.
- [mod](http://clojuredocs.org/clojure_core/clojure.core/mod) Modulo.
- [rem](http://clojuredocs.org/clojure_core/clojure.core/rem) Remainder.
- [even?](http://clojuredocs.org/clojure_core/clojure.core/even_q) Is number even?
- [odd?](http://clojuredocs.org/clojure_core/clojure.core/odd_q) Is number odd?
- [every?](http://clojuredocs.org/clojure_core/clojure.core/every_q) Runs a test
  function over a collection. Returns true if test passes for each item in
  collection.

Functions
---------

- [defn](http://clojuredocs.org/clojure_core/clojure.core/defn) Define a function.
- [fn](http://clojuredocs.org/clojure_core/clojure.core/fn) Create a function.

Strings
-------

- [str](http://clojuredocs.org/clojure_core/clojure.core/str) Convert to string.

Naming
------

- [let](http://clojuredocs.org/clojure_core/clojure.core/let) Allows you to
  name things. Like local variables.
- [def](http://clojuredocs.org/clojure_core/clojure.core/def) Give something a
  global name.

Output
------

- [println](http://clojuredocs.org/clojure_core/clojure.core/def) Output a
  string with a newline.

