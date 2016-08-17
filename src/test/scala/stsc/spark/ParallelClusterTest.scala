package stsc

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

import org.scalatest.{FlatSpec, Matchers}

import java.io.File

class ParallelClusterTest extends FlatSpec with Matchers {
    "The simplest test" should "work" in {
        val conf = new SparkConf().setAppName("ParallelClusterTest").setMaster("local")
        val sc = new SparkContext(conf)

        val dataPath = getClass.getResource("/tt0.csv").getPath()
        val ttPath = getClass.getResource("/kdt0.csv").getPath()
        STSC.sparkCluster(sc, dataPath, ttPath, "clusters.csv")
        new File("clusters.csv").delete()
    }
}
