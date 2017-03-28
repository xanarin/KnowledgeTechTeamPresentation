Maven Tech Team Tutorial
===

This is the code that powers the single web page and presentation that comprises the tutorial for Maven.

## Developing the website
1. First, install [hugo](https://gohugo.io/)
2. Go into the `website/` folder, and run the command `hugo serve`
3. The command will being serving the site at the specified address and port. _The default is http://localhost:1313/_
4. As you change the content in the files, the page will automatically reload and reflect your changes.

## Developing the presentation
1. First, install [node](https://nodejs.org/en/)
2. Go into the `presentation/` folder, and run the command `npm install`
3. Run the command `grunt serve` to start the webserver.
3. The command will being serving the site at the specified address and port.
4. As you change the content in the files, the page will automatically reload and reflect your changes.

## Changing Website Content
The file you probably want to change is **website/content/blog/maven-tutorial.md**. It is written in [Markdown](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet), but you can also place HTML directly into the file (for images and such).

## Changing Presentation Content
The file you probably want to change is **presentation/content.md**. It is written in [Markdown](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet), but you can also place HTML directly into the file (for images and such).
