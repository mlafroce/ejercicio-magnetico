// imports node plugin which allows us to save data to a file for example css external files
var ExtractTextPlugin = require("extract-text-webpack-plugin");
// cleans defined folders before webpack will build new files now we can remove package.json commands "rm -rf ./dist && ..."
var CleanWebpackPlugin = require("clean-webpack-plugin");
// copies to memory html from template file and injects css and javascript as well as img src to newly generated html file. 
var HtmlWebpackPlugin = require("html-webpack-plugin");
// to include jquery we need to import 'jquery' in app.js but also we need to make connection between bundle.js jquery script
var Webpack = require('webpack');
// includes node path resover that is need for webpack-dev-server to run properly
var path = require('path');
var CopyWebpackPlugin = require('copy-webpack-plugin');


// webpack configuration 
module.exports = {
  entry: [
    path.resolve(__dirname, "src/app.js"),
  ],
  output: {
    path: path.resolve(__dirname, 'dist'), // defins the main utput directory
    filename: 'js/bundle.js',
  },
  devServer: {
    contentBase: path.join(__dirname, "dist"),
    compress: true,
    port: 8080,
  },
  module: {
    rules: [
      { 
        test: /\.(html)$/,
        use:
          [
            {
              loader: 'file-loader',
              options: {
                name: '[path][name].[ext]',
                context: './src',
                outputPath: '/',
                publicPath: '/'
              }
            }, 

          ]
      },
      {
        test: /\.(jpg|png|gif)$/,
        use: {
          loader: 'file-loader',
          options: {
            name: '[name].[ext]',
            outputPath: 'img/',
            publicPath: '/' // this path relates to reference path from the index.html file that imports out bundle.js file
          }
        }
      },
      {
        test:  /\.js$/,
        use: [
          {
            loader: 'babel-loader',
            options: {
              presets: ['@babel/preset-env']
            }
          }
        ]
      },
      {
        test: /\.scss$/,
        include: [
          path.resolve(__dirname, "src/sass")
        ],
        use: ExtractTextPlugin.extract({
          fallback: 'style-loader',
          //resolve-url-loader may be chained before sass-loader if necessary
          use: [
            {
              loader: 'css-loader',
              options: {
                minimize: false,
                sourceMap: true,
              }
            },
            'scss-loader'
          ]
        })
      },
      {
        test: /\.css$/,
        use: ['style-loader', 'css-loader']
      }
    ]
  },
  plugins: [
    // mapping jQuery variable to our node module dependency (remember to import 'jquery' in app.js)
    // below we make jquery available as both the $ and jQuery variable
    new Webpack.ProvidePlugin({
      $: 'jquery',
      jQuery: 'jquery'
    }),
    // use extract plugin to build an external file loded by sass-loader > complied to css > movig to bundle.css
    new ExtractTextPlugin({
      filename: 'css/bundle.css'
    }),
    // remove all files from this folder before generating new files
    //new CleanWebpackPlugin(['dist']),
    // Copy non-js files
    new CopyWebpackPlugin([
        {from:'src/index.html',to:'index.html'}
    ])
  ],
  devServer: {
    contentBase: path.join(__dirname, 'dist'),
    compress: true,
    port: 9000
  }
}
