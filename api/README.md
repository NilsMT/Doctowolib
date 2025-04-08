# API DoctOwOlib GIN

## Technologies :

- WebFramework : [Gin](https://gin-gonic.com/) 
- Driver Mongo [MongoDB Official go driver](https://www.mongodb.com/docs/languages/go/)

## Guide de dévelopement :

**Installer le SDK go :**

Guide pour Vscodium flatpak :
```sh
# Trouver quelle version du sdk est nécéssaire
flatpak info --show-extensions com.vscodium.codium | grep "Runtime"
# Choisir la même version
flatpak install org.freedesktop.Sdk.Extension.golang
# Ajouter go au SDK (oubliez pas de rajouter les SDKs déjà existant)
sudo flatpak override --env=FLATPAK_ENABLE_SDK_EXT=golang com.vscodium.codium
```

**Télécharger Gin :**
```sh
go get -u github.com/gin-gonic/gin
```

**Lancer le projet :**
```sh
go run main.go
```