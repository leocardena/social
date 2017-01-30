var gulp = require("gulp");
var sass = require("gulp-sass");
var notify = require("gulp-notify");

gulp.task('compile-css', function(){
	return gulp.src("./src/main/resources/static/sass/*.scss")
			.pipe(sass({outputStyle:'compressed'}))
			.on('error', notify.onError())
			.pipe(gulp.dest("./src/main/resources/static/content/css"));
});

gulp.task('watch', function(){
	gulp.watch('./src/main/resources/static/**/*.scss', ['compile-css']);
});

gulp.task('default', ['compile-css', 'watch']);