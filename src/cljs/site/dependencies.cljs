;; NOTE. USE $ and $! for all interop.
;; its that or externs and I am laaaaaaazy
(ns site.dependencies
  (:require [reagent.interop :refer-macros [$]]))

;; deps is a js array of dependencies
(def deps ($ js/window :deps))

(def react-player ($ deps :react-player))
(def material-ui ($ deps :material-ui))

;; See for explanation
;; http://stackoverflow.com/questions/20443545/private-def-in-clojure-clojurescript
(defmacro def- [sym init]
  `(def ~(with-meta sym {:private true}) ~init))
