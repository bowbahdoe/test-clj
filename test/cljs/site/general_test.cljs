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

(deftest give-indexed-keys
  (testing "site.general/give-indexed-keys"
    (is (= (meta (first (g/give-indexed-keys [[1 2 3]])) )
           {:key 0}))
    (is (= (meta (first (g/give-indexed-keys [[]])) )
           {:key 0}))
    (is (= (g/give-indexed-keys [])
           []))
    (is (= (g/give-indexed-keys '())
           '()))
    (is (= (meta (nth (vec (g/give-indexed-keys ['(1 2 3) '(1 2) ["hi"]])) 2))
           {:key 2}))
    (is (= (g/give-indexed-keys [[1 2 3] [1 2] [1]])
        [[1 2 3] [1 2] [1]]))))
