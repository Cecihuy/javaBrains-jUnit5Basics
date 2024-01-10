This repo based on video course 'JUnit 5 Basics'.
For more detail, please visit their channel on youtube.
https://www.youtube.com/@Java.Brains

I use VScode IDE for doing these course.
Some extensions has to be installed in order to run JUnit.
In this case i use 'Test Runner for Java' extension by Microsoft.

Course number 25 need some configuration to run @Tag annotation.
Configuration can be found from extension settings in settings.json file.
You can copy these settings under java.test.config

"java.test.config": {
        "testKind": "junit",
        "filters": {
            "tags": [
                "Circle",    // ---> include tag 'foo'
                "!Math"    // ---> exclude tag 'bar'
            ]
        }        
    }