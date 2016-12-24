(ns site.general-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [site.general :as g]))

(deftest enumerate-test
  (testing "site.general/enumerate"
    (is (= (g/enumerate []) []))
    (is (= (g/enumerate '()) []))
    (is (= (g/enumerate ['a]) ['(0 a)]))
    (is (= (g/enumerate '(a)) ['(0 a)]))
    (is (= (g/enumerate ['a 'b 'c])
           ['(0 a) '(1 b) '(2 c)]))
    (is (= (g/enumerate '(a b c))
           ['(0 a) '(1 b) '(2 c)]))))
