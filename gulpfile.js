var gulp = require("gulp");
var sass = require("gulp-sass");
var notify = require("gulp-notify");
var concat = require('gulp-concat');  
var rename = require('gulp-rename');  
var uglify = require('gulp-uglify');  
var mainBowerFiles = require('gulp-main-bower-files');

gulp.task('compile-css', function(){
	return gulp.src("./src/main/resources/static/sass/*.scss")
			.pipe(sass({outputStyle:'compressed'}))
			.on('error', notify.onError())
			.pipe(gulp.dest("./src/main/resources/static/content/css"));
});

gulp.task('watch', function(){
	gulp.watch('./src/main/resources/static/**/*.scss', ['compile-css']);
});

gulp.task('watch-js', function(){
	gulp.watch('./src/main/resources/static/app/**/.js', ['scripts']);
});

gulp.task('scripts', function() {  
	var jsMain = './src/main/resources/static/app/**/*.main.module.js',  
	jsCore = './src/main/resources/static/app/**/*.core.module.js',
	jsModule = './src/main/resources/static/app/**/*.module.js',
	jsController = './src/main/resources/static/app/**/*.controller.js',
	jsInterceptor = './src/main/resources/static/app/**/*.interceptor.js',
	jsConfig = './src/main/resources/static/app/**/*.config.js',
	jsHandler = './src/main/resources/static/app/**/*.handler.js',
	jsValue = './src/main/resources/static/app/**/*.value.js',
	jsService = './src/main/resources/static/app/**/*.service.js',
	jsController = './src/main/resources/static/app/**/*.controller.js',
	jsRoutes = './src/main/resources/static/app/**/*.routes.js',
	jsState = './src/main/resources/static/app/**/*.state.js',
	jsDirective = './src/main/resources/static/app/**/*.directive.js',
	jsDest = './src/main/resources/static/dist';
	
	return gulp.src([jsMain, jsCore, jsModule, jsController, jsInterceptor, jsConfig, jsHandler, jsValue, jsService,
		jsController, jsRoutes, jsState, jsDirective])
	    .pipe(concat('main.js'))
	    .pipe(gulp.dest(jsDest))
	    .pipe(rename('main.min.js'))
        .pipe(uglify())
        .pipe(gulp.dest(jsDest));
});

gulp.task("bower-files", function(){
	 var angular = './src/main/resources/static/bower_components/angular/angular.min.js', 
	 router = './src/main/resources/static/bower_components/angular-ui-router/release/angular-ui-router.min.js', 
	 wizard = './src/main/resources/static/bower_components/angular-wizard/dist/angular-wizard.min.js', 
	 bootstrap = './src/main/resources/static/bower_components/angular-bootstrap/ui-bootstrap-tpls.min.js', 
	 locale = './src/main/resources/static/bower_components/angular-i18n/angular-locale_pt-br.js', 
	 resource = './src/main/resources/static/bower_components/angular-resource/angular-resource.min.js', 
	 loadingBar = './src/main/resources/static/bower_components/angular-loading-bar/build/loading-bar.min.js', 
	 cache = './src/main/resources/static/bower_components/angular-cache-buster/angular-cache-buster.js', 
	 mask = './src/main/resources/static/bower_components/angular-ui-mask/dist/mask.min.js', 
	 storage = './src/main/resources/static/bower_components/ngstorage/ngStorage.min.js', 
	 cookies = './src/main/resources/static/bower_components/angular-cookies/angular-cookies.min.js', 
	 inputMasks = './src/main/resources/static/bower_components/angular-input-masks/angular-input-masks-standalone.min.js', 
	 translate = './src/main/resources/static/bower_components/angular-translate/angular-translate.min.js', 
	 youtube = './src/main/resources/static/bower_components/ng-youtube-embed/build/ng-youtube-embed.min.js', 
	 rate = './src/main/resources/static/bower_components/angular-rateit/dist/ng-rateit.min.js', 
	 upload = './src/main/resources/static/bower_components/ng-file-upload/ng-file-upload.min.js', 
	 uploadShim = './src/main/resources/static/bower_components/ng-file-upload/ng-file-upload-shim.min.js';
	 
	 var jsDest = './src/main/resources/static/dist';

	 return gulp.src([angular, router, wizard, bootstrap, locale, resource, loadingBar, cache, mask, storage,
		 cookies, inputMasks, translate, youtube, rate, upload, uploadShim])
		 .pipe(concat('lib.js'))
		 .pipe(gulp.dest(jsDest))
		 .pipe(rename('lib.min.js'))
		 .pipe(uglify())
		 .pipe(gulp.dest(jsDest));
});

gulp.task('default', ['compile-css', 'watch', 'scripts', 'bower-files']);
gulp.task('compile', ['compile-css', 'scripts', 'bower-files']);