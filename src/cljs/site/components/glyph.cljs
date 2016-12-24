;; DEPENDS ON BOOTSTRAP
(ns site.components.glyph
  (:require [re-frame.core :as re-frame]
            [re-com.core :as re-com]))

;; A Glyph-Name is a string representing a glyph
;; A full reference can be found @ http://glyphicons.com/

;; Glyph-Name -> HTML
;; Renders the given glyph
(defn glyph [glyph-name]
  [:span {:class (str "glyphicon " glyph-name)
         :aria-hidden true}])
