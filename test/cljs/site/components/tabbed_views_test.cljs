(ns site.components.tabbed-view-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [site.components.tabbed-view :as tv]))

(deftest make-switcher-test
  (testing "site.components.tabbed-view/make-switcher"
    (is (fn? (tv/make-switcher 0))
    (is (fn? (tv/make-switcher 10))))))
