package design.messagebroker3;

/**
 *
 * Producer
 *  - Create Topic
 *  - Send message
 *
 *  Consumer
 *  - Subscribe for Topic of broker
 *  - Read from message
 *
 *  Broker
 *  - Create Topic
 *    - Create object and store mapping of topic to subsriber
 *  - Subscribe
 *     - Add consumer to subscriber and create queue for subscriber
 *  - Send message
 *     - Get all consumers and add to consumer queue
 *
 */