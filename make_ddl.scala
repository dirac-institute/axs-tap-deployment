// Run with bin/spark-shell --conf spark.hadoop.fs.s3a.aws.credentials.provider=com.amazonaws.auth.DefaultAWSCredentialsProviderChain -I make_ddl.scala
// val table_name = "ztf_oct19"
// val path = "s3a://axscatalog/ztf_oct19/"
val table_name = "gaiadr2.gaia_source"
val path = "s3a://axscatalog/gaiadr2/"
val df = spark.read.parquet(path)
val schema = df.schema
var columns = schema.fields
val column_strings = (for(column <- columns) yield column.name+" "+column.dataType.sql).mkString(",")
println(s"CREATE EXTERNAL TABLE $table_name ($column_strings) STORED AS PARQUET LOCATION '$path'")

