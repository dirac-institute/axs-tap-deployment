
val table_name = "gaia_dr2"
val path = "s3a://axscatalog/gaiadr2/"
val df = spark.read.parquet(path)
val schema = df.schema
var columns = schema.fields
val column_strings = (for(column <- columns) yield column.name+" "+column.dataType.sql).mkString(",")
println(s"CREATE EXTERNAL TABLE $table_name ($column_strings) STORED AS PARQUET LOCATION '$path'")

