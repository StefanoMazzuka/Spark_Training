# Spark Training

Ejemplos prácticos y documentación de los módulos de Spark.

## Diagrama de Arquitectura
![Image of Yaktocat](https://github.com/StefanoMazzuka/Spark_Training/blob/master/img/diagrama_arquitectura.png)


## Características

RDD (Resilient Distributed Dataset) Conjunto sólido de datos distribuidos.
Evaluación perezosa: las transformaciones no se resuelven, se almacenan en un DAG y al ejecutar una acción se ejecutan todas las transformaciones.

## Componentes
### Spark Core 
Conjunto de librerías.

### Spark SQL
Procesamiento de datos estructurados y semi-estructurados.

### Spark Streaming
Procesamiento de datos en tiempo real.

### Spark MLLib
Librería de Machine Learning.

### Spark Graph
Procesamiento y operaciones de grafos, DAG.

## Spark Session
## Spark Context
Contexto básico de Spark, desde donde se crean el resto de variables.
En la shell de Spark viene directamente instancia en la variable «sc», aunque en otros entornos hay que instanciarlo explícitamente.
Problema que solo se puede instancias una sola vez por JVM.
La configuración de la estancia se puede definir mediante SparkConf.












What things you need to install the software and how to install them

```
Give examples
```

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
