(ns site.components.tabbed-view-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [site.components.tabbed-view :as tv]))

(deftest enumerate-test
  (testing "site.views/enumerate"
    (is (= (tv/enumerate []) []))
    (is (= (tv/enumerate '()) []))
    (is (= (tv/enumerate ['a]) ['(0 a)]))
    (is (= (tv/enumerate '(a)) ['(0 a)]))
    (is (= (tv/enumerate ['a 'b 'c])
           ['(0 a) '(1 b) '(2 c)]))
    (is (= (tv/enumerate '(a b c))
           ['(0 a) '(1 b) '(2 c)]))))

(deftest make-switcher-test
  (testing "site.views/make-switcher"
    (is (fn? (tv/make-switcher 0))
    (is (fn? (tv/make-switcher 10))))))
