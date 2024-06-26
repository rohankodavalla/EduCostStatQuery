// source: query5.proto
/**
 * @fileoverview
 * @enhanceable
 * @suppress {missingRequire} reports error on implicit type usages.
 * @suppress {messageConventions} JS Compiler reports an error if a variable or
 *     field starts with 'MSG_' and isn't a translatable message.
 * @public
 */
// GENERATED CODE -- DO NOT EDIT!
/* eslint-disable */
// @ts-nocheck

var jspb = require('google-protobuf');
var goog = jspb;
var global =
    (typeof globalThis !== 'undefined' && globalThis) ||
    (typeof window !== 'undefined' && window) ||
    (typeof global !== 'undefined' && global) ||
    (typeof self !== 'undefined' && self) ||
    (function () { return this; }).call(null) ||
    Function('return this')();

goog.exportSymbol('proto.edu_cost_stat.QueryFiveRequest', null, global);
goog.exportSymbol('proto.edu_cost_stat.QueryFiveResponse', null, global);
/**
 * Generated by JsPbCodeGenerator.
 * @param {Array=} opt_data Optional initial data array, typically from a
 * server response, or constructed directly in Javascript. The array is used
 * in place and becomes part of the constructed object. It is not cloned.
 * If no data is provided, the constructed object will be empty, but still
 * valid.
 * @extends {jspb.Message}
 * @constructor
 */
proto.edu_cost_stat.QueryFiveRequest = function(opt_data) {
  jspb.Message.initialize(this, opt_data, 0, -1, null, null);
};
goog.inherits(proto.edu_cost_stat.QueryFiveRequest, jspb.Message);
if (goog.DEBUG && !COMPILED) {
  /**
   * @public
   * @override
   */
  proto.edu_cost_stat.QueryFiveRequest.displayName = 'proto.edu_cost_stat.QueryFiveRequest';
}
/**
 * Generated by JsPbCodeGenerator.
 * @param {Array=} opt_data Optional initial data array, typically from a
 * server response, or constructed directly in Javascript. The array is used
 * in place and becomes part of the constructed object. It is not cloned.
 * If no data is provided, the constructed object will be empty, but still
 * valid.
 * @extends {jspb.Message}
 * @constructor
 */
proto.edu_cost_stat.QueryFiveResponse = function(opt_data) {
  jspb.Message.initialize(this, opt_data, 0, -1, null, null);
};
goog.inherits(proto.edu_cost_stat.QueryFiveResponse, jspb.Message);
if (goog.DEBUG && !COMPILED) {
  /**
   * @public
   * @override
   */
  proto.edu_cost_stat.QueryFiveResponse.displayName = 'proto.edu_cost_stat.QueryFiveResponse';
}



if (jspb.Message.GENERATE_TO_OBJECT) {
/**
 * Creates an object representation of this proto.
 * Field names that are reserved in JavaScript and will be renamed to pb_name.
 * Optional fields that are not set will be set to undefined.
 * To access a reserved field use, foo.pb_<name>, eg, foo.pb_default.
 * For the list of reserved names please see:
 *     net/proto2/compiler/js/internal/generator.cc#kKeyword.
 * @param {boolean=} opt_includeInstance Deprecated. whether to include the
 *     JSPB instance for transitional soy proto support:
 *     http://goto/soy-param-migration
 * @return {!Object}
 */
proto.edu_cost_stat.QueryFiveRequest.prototype.toObject = function(opt_includeInstance) {
  return proto.edu_cost_stat.QueryFiveRequest.toObject(opt_includeInstance, this);
};


/**
 * Static version of the {@see toObject} method.
 * @param {boolean|undefined} includeInstance Deprecated. Whether to include
 *     the JSPB instance for transitional soy proto support:
 *     http://goto/soy-param-migration
 * @param {!proto.edu_cost_stat.QueryFiveRequest} msg The msg instance to transform.
 * @return {!Object}
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.edu_cost_stat.QueryFiveRequest.toObject = function(includeInstance, msg) {
  var f, obj = {
    year: jspb.Message.getFieldWithDefault(msg, 1, 0),
    type: jspb.Message.getFieldWithDefault(msg, 2, ""),
    length: jspb.Message.getFieldWithDefault(msg, 3, "")
  };

  if (includeInstance) {
    obj.$jspbMessageInstance = msg;
  }
  return obj;
};
}


/**
 * Deserializes binary data (in protobuf wire format).
 * @param {jspb.ByteSource} bytes The bytes to deserialize.
 * @return {!proto.edu_cost_stat.QueryFiveRequest}
 */
proto.edu_cost_stat.QueryFiveRequest.deserializeBinary = function(bytes) {
  var reader = new jspb.BinaryReader(bytes);
  var msg = new proto.edu_cost_stat.QueryFiveRequest;
  return proto.edu_cost_stat.QueryFiveRequest.deserializeBinaryFromReader(msg, reader);
};


/**
 * Deserializes binary data (in protobuf wire format) from the
 * given reader into the given message object.
 * @param {!proto.edu_cost_stat.QueryFiveRequest} msg The message object to deserialize into.
 * @param {!jspb.BinaryReader} reader The BinaryReader to use.
 * @return {!proto.edu_cost_stat.QueryFiveRequest}
 */
proto.edu_cost_stat.QueryFiveRequest.deserializeBinaryFromReader = function(msg, reader) {
  while (reader.nextField()) {
    if (reader.isEndGroup()) {
      break;
    }
    var field = reader.getFieldNumber();
    switch (field) {
    case 1:
      var value = /** @type {number} */ (reader.readInt32());
      msg.setYear(value);
      break;
    case 2:
      var value = /** @type {string} */ (reader.readString());
      msg.setType(value);
      break;
    case 3:
      var value = /** @type {string} */ (reader.readString());
      msg.setLength(value);
      break;
    default:
      reader.skipField();
      break;
    }
  }
  return msg;
};


/**
 * Serializes the message to binary data (in protobuf wire format).
 * @return {!Uint8Array}
 */
proto.edu_cost_stat.QueryFiveRequest.prototype.serializeBinary = function() {
  var writer = new jspb.BinaryWriter();
  proto.edu_cost_stat.QueryFiveRequest.serializeBinaryToWriter(this, writer);
  return writer.getResultBuffer();
};


/**
 * Serializes the given message to binary data (in protobuf wire
 * format), writing to the given BinaryWriter.
 * @param {!proto.edu_cost_stat.QueryFiveRequest} message
 * @param {!jspb.BinaryWriter} writer
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.edu_cost_stat.QueryFiveRequest.serializeBinaryToWriter = function(message, writer) {
  var f = undefined;
  f = message.getYear();
  if (f !== 0) {
    writer.writeInt32(
      1,
      f
    );
  }
  f = message.getType();
  if (f.length > 0) {
    writer.writeString(
      2,
      f
    );
  }
  f = message.getLength();
  if (f.length > 0) {
    writer.writeString(
      3,
      f
    );
  }
};


/**
 * optional int32 year = 1;
 * @return {number}
 */
proto.edu_cost_stat.QueryFiveRequest.prototype.getYear = function() {
  return /** @type {number} */ (jspb.Message.getFieldWithDefault(this, 1, 0));
};


/**
 * @param {number} value
 * @return {!proto.edu_cost_stat.QueryFiveRequest} returns this
 */
proto.edu_cost_stat.QueryFiveRequest.prototype.setYear = function(value) {
  return jspb.Message.setProto3IntField(this, 1, value);
};


/**
 * optional string type = 2;
 * @return {string}
 */
proto.edu_cost_stat.QueryFiveRequest.prototype.getType = function() {
  return /** @type {string} */ (jspb.Message.getFieldWithDefault(this, 2, ""));
};


/**
 * @param {string} value
 * @return {!proto.edu_cost_stat.QueryFiveRequest} returns this
 */
proto.edu_cost_stat.QueryFiveRequest.prototype.setType = function(value) {
  return jspb.Message.setProto3StringField(this, 2, value);
};


/**
 * optional string length = 3;
 * @return {string}
 */
proto.edu_cost_stat.QueryFiveRequest.prototype.getLength = function() {
  return /** @type {string} */ (jspb.Message.getFieldWithDefault(this, 3, ""));
};


/**
 * @param {string} value
 * @return {!proto.edu_cost_stat.QueryFiveRequest} returns this
 */
proto.edu_cost_stat.QueryFiveRequest.prototype.setLength = function(value) {
  return jspb.Message.setProto3StringField(this, 3, value);
};





if (jspb.Message.GENERATE_TO_OBJECT) {
/**
 * Creates an object representation of this proto.
 * Field names that are reserved in JavaScript and will be renamed to pb_name.
 * Optional fields that are not set will be set to undefined.
 * To access a reserved field use, foo.pb_<name>, eg, foo.pb_default.
 * For the list of reserved names please see:
 *     net/proto2/compiler/js/internal/generator.cc#kKeyword.
 * @param {boolean=} opt_includeInstance Deprecated. whether to include the
 *     JSPB instance for transitional soy proto support:
 *     http://goto/soy-param-migration
 * @return {!Object}
 */
proto.edu_cost_stat.QueryFiveResponse.prototype.toObject = function(opt_includeInstance) {
  return proto.edu_cost_stat.QueryFiveResponse.toObject(opt_includeInstance, this);
};


/**
 * Static version of the {@see toObject} method.
 * @param {boolean|undefined} includeInstance Deprecated. Whether to include
 *     the JSPB instance for transitional soy proto support:
 *     http://goto/soy-param-migration
 * @param {!proto.edu_cost_stat.QueryFiveResponse} msg The msg instance to transform.
 * @return {!Object}
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.edu_cost_stat.QueryFiveResponse.toObject = function(includeInstance, msg) {
  var f, obj = {
    averageExpense: jspb.Message.getFloatingPointFieldWithDefault(msg, 1, 0.0)
  };

  if (includeInstance) {
    obj.$jspbMessageInstance = msg;
  }
  return obj;
};
}


/**
 * Deserializes binary data (in protobuf wire format).
 * @param {jspb.ByteSource} bytes The bytes to deserialize.
 * @return {!proto.edu_cost_stat.QueryFiveResponse}
 */
proto.edu_cost_stat.QueryFiveResponse.deserializeBinary = function(bytes) {
  var reader = new jspb.BinaryReader(bytes);
  var msg = new proto.edu_cost_stat.QueryFiveResponse;
  return proto.edu_cost_stat.QueryFiveResponse.deserializeBinaryFromReader(msg, reader);
};


/**
 * Deserializes binary data (in protobuf wire format) from the
 * given reader into the given message object.
 * @param {!proto.edu_cost_stat.QueryFiveResponse} msg The message object to deserialize into.
 * @param {!jspb.BinaryReader} reader The BinaryReader to use.
 * @return {!proto.edu_cost_stat.QueryFiveResponse}
 */
proto.edu_cost_stat.QueryFiveResponse.deserializeBinaryFromReader = function(msg, reader) {
  while (reader.nextField()) {
    if (reader.isEndGroup()) {
      break;
    }
    var field = reader.getFieldNumber();
    switch (field) {
    case 1:
      var value = /** @type {number} */ (reader.readDouble());
      msg.setAverageExpense(value);
      break;
    default:
      reader.skipField();
      break;
    }
  }
  return msg;
};


/**
 * Serializes the message to binary data (in protobuf wire format).
 * @return {!Uint8Array}
 */
proto.edu_cost_stat.QueryFiveResponse.prototype.serializeBinary = function() {
  var writer = new jspb.BinaryWriter();
  proto.edu_cost_stat.QueryFiveResponse.serializeBinaryToWriter(this, writer);
  return writer.getResultBuffer();
};


/**
 * Serializes the given message to binary data (in protobuf wire
 * format), writing to the given BinaryWriter.
 * @param {!proto.edu_cost_stat.QueryFiveResponse} message
 * @param {!jspb.BinaryWriter} writer
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.edu_cost_stat.QueryFiveResponse.serializeBinaryToWriter = function(message, writer) {
  var f = undefined;
  f = message.getAverageExpense();
  if (f !== 0.0) {
    writer.writeDouble(
      1,
      f
    );
  }
};


/**
 * optional double average_expense = 1;
 * @return {number}
 */
proto.edu_cost_stat.QueryFiveResponse.prototype.getAverageExpense = function() {
  return /** @type {number} */ (jspb.Message.getFloatingPointFieldWithDefault(this, 1, 0.0));
};


/**
 * @param {number} value
 * @return {!proto.edu_cost_stat.QueryFiveResponse} returns this
 */
proto.edu_cost_stat.QueryFiveResponse.prototype.setAverageExpense = function(value) {
  return jspb.Message.setProto3FloatField(this, 1, value);
};


goog.object.extend(exports, proto.edu_cost_stat);
