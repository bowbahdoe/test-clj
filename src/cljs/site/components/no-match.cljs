(ns site.components.no-match)

(def styles {
  :fourofour {
    :color "#B388FF",
    :fontWeight "100",
    :fontSize "70px"
  },
  :pnf {
    :color "#546E7A",
    :fontSize "40px"
  },
  :center {
    :textAlign "center"
  }
})

(defn no-match []
  [:div {:style (:center styles)}
    [:div {:style (:fourofour styles)} 404]
    [:div {:style (:pnf styles)} "Page Not Found"]])
