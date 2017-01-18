# SaveClasses
Basic structure of a project that can save class instances to a remote server

Assumptions

The remote server takes a class ID and a JSON string as a representation of a class
These 2 parameters must be stored together and returned together so the caller can recreate the class instances

The contents of any class stored in this way may need one or more ID fields internally so they can be reconnected properly
in the client application once retrieved from the server.
