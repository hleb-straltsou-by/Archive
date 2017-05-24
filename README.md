# Archive
This app is designed to provide access to the archive with dossiers using client-server architecture and also providing REST interface. 
# Task:

- create a client-server application "Archive";
- archive is a catalog of personal files per person (fio, contact
Information, place and work experience, etc.);
- The archive is on the server;
- the client GUI implementation should use one of the following libraries:
Swing / SWT / JavaFX;
- Each client has a set of roles;
- there are three roles (you can associate the role == level of rights): to view,
To change, to create and delete a case;
- provide for the presence of an "administrator" client, which can
Change the rights / roles of existing customers / users;
- use sockets to implement a network connection;
- client request and server response are sent in serialized form;
- The format of storing personal files on the server - xml-files;
- In the protection of laboratory work, the process of building and running an application
Produce from the console (not from under the IDE);
- the administrator must be able to specify the type of parser on the
Server side: SAX, StAX, DOM;
- the server performs an analysis of the xml-document (for example, coming from
Administrator "to create a case") by the corresponding kind of parser and sends
User response in the form of a collection of objects;
- when retrieving information, the client restores the data by deserializing it and
Outputs;
- for the validation of the xml-file, it is necessary to develop an appropriate xsd-scheme
(When developing an xsd schema, it is mandatory to use the ID type, simple and complex types,
Transfers);
- Another additional server-side parser: JDOM;
- before saving personal files, organize their compression (archiving);
- provide a REST interface for viewing personal files.
