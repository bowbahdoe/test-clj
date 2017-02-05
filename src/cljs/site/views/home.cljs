(ns site.views.home
  (:require [site.views.root :refer [main-panel]]))

(defmethod main-panel 'home []
  [:h1 "Welcome"])
