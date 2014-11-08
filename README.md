messaging-server
================

Simple Java-based messaging server with support for message queues and topics

How it works
------------

Once the server is started, it listens for incoming clients. It creates a `Client`
`Runnable` for each incoming client and passes to it the unique references to
`TopicListInterface` and `MessageQueueInterface`. Then clients can communicate
via these interfaces in a thread-safe manner. Since communication is done via
sockets, only text can be sent by the client; the `Client` `Runnable` parses
this text and maps it to the appropiate interface method.

The messaging server can handle two types of objects:

- Topics (may have multiple Posts; anyone can subscribe to a topic);
- Messages (only selected receiver can view a message).

Topics
------

`Topic`s are stored in a `TopicList`. Because concurrency is needed, `TopicList` is
wrapped in a `TopicListInterface` (unique across the application), having all
methods defined as `synchronized`.

`Post`s are stored in their associated `Topic`. They are deleted after they expire.

In order to add a new topic/post, a `Client` needs to call the appropiate method (`addTopic`/`addPost`)
on `TopicListInterface` (automatically assigned when `Client` is created).

```
[add Topic]
Client -> TopicListInterface -> TopicList -> Topic

[add Post]
Client -> TopicListInterface -> TopicList -> Topic -> Post
```

Messages
--------

`Message`s are stored in a `MessageQueue`. Because concurrency is needed,
`MessageQueue` is wrapped in a `MessageQueueInterface` (unique across the
application), having all methods defined as `synchronized`.

In order to add a new message, a `Client` needs to call the appropiate method (push)
on `MessageQueueInterface` (automatically assigned when `Client` is created).

`MessageQueue` has a limit of `Message`s that it can store.

`Message`s are appended to the `MessageQueue` (at the end) and popped from the
`MessageQueue` (at the front, the removed) if the given receiver matches the
first `Message`'s receiver.

```
[add Message]
Client -> MessageQueueInterface -> MessageQueue -> Message
```
