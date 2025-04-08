# Script de filtrage de donnée

Script python qui télécharge et filtre les données obtenue depuis la base de donnée publique

## Utilisation :

Install the `requirements.txt` :
```
pip install -r requirements.txt
``` 

Pour les données de la BDPM :

`fetch` → `decode` → ...

Pour les données de l'ANSM :

`fetch` → `decode` → `format` → `export`

## Test :

Les tests peuvent être lancer avec `coverage` :
```bash
coverage run -m unittest
```

La couverture peut être visualisée avec :
```bash
coverage report -m
```