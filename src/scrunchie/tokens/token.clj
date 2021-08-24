(ns scrunchie.tokens.token)

(defrecord Token [path value comment file])

(defn token->new [path value comment file] (->Token path value comment))
