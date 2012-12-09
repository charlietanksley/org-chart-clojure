# Org-chart (Clojure)

Org-chart is a simple api to show the organizational
connections between individuals (e.g., show what other organizations
members of a given organization are members of).

This particular implementation is written in Clojure.

## Usage and Limitations

Right now this api is written without using any authentication with
Github. That means we are limited to 60 API requests an hour. That
isn't many, and this app is rather inefficient in using them, so if
you look for an organization of any size you'll run out in a hurry. So
if you want to test it out, try it with a small organization, like
RSpec.

Example:

```
http://<base-url>/api/rspec.json
```

## Prerequisites

You will need [Leiningen][1] 1.7.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server

## License

Copyright © 2012 Charlie Tanksley
