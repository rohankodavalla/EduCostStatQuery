// source: query1.proto
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

goog.exportSymbol('proto.edu_cost_stat.QueryOneRequest', null, global);
goog.exportSymbol('proto.edu_cost_stat.QueryOneResponse', null, global);
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
proto.edu_cost_stat.QueryOneRequest = function(opt_data) {
  jspb.Message.initialize(this, opt_data, 0, -1, null, null);
};
goog.inherits(proto.edu_cost_stat.QueryOneRequest, jspb.Message);
if (goog.DEBUG && !COMPILED) {
  /**
   * @public
   * @override
   */
  proto.edu_cost_stat.QueryOneRequest.displayName = 'proto.edu_cost_stat.QueryOneRequest';
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
proto.edu_cost_stat.QueryOneResponse = function(opt_data) {
  jspb.Message.initialize(this, opt_data, 0, -1, null, null);
};
goog.inherits(proto.edu_cost_stat.QueryOneResponse, jspb.Message);
if (goog.DEBUG && !COMPILED) {
  /**
   * @public
   * @override
   */
  proto.edu_cost_stat.QueryOneResponse.displayName = 'proto.edu_cost_stat.QueryOneResponse';
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
proto.edu_cost_stat.QueryOneRequest.prototype.toObject = function(opt_includeInstance) {
  return proto.edu_cost_stat.QueryOneRequest.toObject(opt_includeInstance, this);
};


/**
 * Static version of the {@see toObject} method.
 * @param {boolean|undefined} includeInstance Deprecated. Whether to include
 *     the JSPB instance for transitional soy proto support:
 *     http://goto/soy-param-migration
 * @param {!proto.edu_cost_stat.QueryOneRequest} msg The msg instance to transform.
 * @return {!Object}
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.edu_cost_stat.QueryOneRequest.toObject = function(includeInstance, msg) {
  var f, obj = {
    year: jspb.Message.getFieldWithDefault(msg, 1, 0),
    state: jspb.Message.getFieldWithDefault(msg, 2, ""),
    type: jspb.Message.getFieldWithDefault(msg, 3, ""),
    length: jspb.Message.getFieldWithDefault(msg, 4, ""),
    expense: jspb.Message.getFieldWithDefault(msg, 5, 0)
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
 * @return {!proto.edu_cost_stat.QueryOneRequest}
 */
proto.edu_cost_stat.QueryOneRequest.deserializeBinary = function(bytes) {
  var reader = new jspb.BinaryReader(bytes);
  var msg = new proto.edu_cost_stat.QueryOneRequest;
  return proto.edu_cost_stat.QueryOneRequest.deserializeBinaryFromReader(msg, reader);
};


/**
 * Deserializes binary data (in protobuf wire format) from the
 * given reader into the given message object.
 * @param {!proto.edu_cost_stat.QueryOneRequest} msg The message object to deserialize into.
 * @param {!jspb.BinaryReader} reader The BinaryReader to use.
 * @return {!proto.edu_cost_stat.QueryOneRequest}
 */
proto.edu_cost_stat.QueryOneRequest.deserializeBinaryFromReader = function(msg, reader) {
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
      msg.setState(value);
      break;
    case 3:
      var value = /** @type {string} */ (reader.readString());
      msg.setType(value);
      break;
    case 4:
      var value = /** @type {string} */ (reader.readString());
      msg.setLength(value);
      break;
    case 5:
      var value = /** @type {number} */ (reader.readInt32());
      msg.setExpense(value);
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
proto.edu_cost_stat.QueryOneRequest.prototype.serializeBinary = function() {
  var writer = new jspb.BinaryWriter();
  proto.edu_cost_stat.QueryOneRequest.serializeBinaryToWriter(this, writer);
  return writer.getResultBuffer();
};


/**
 * Serializes the given message to binary data (in protobuf wire
 * format), writing to the given BinaryWriter.
 * @param {!proto.edu_cost_stat.QueryOneRequest} message
 * @param {!jspb.BinaryWriter} writer
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.edu_cost_stat.QueryOneRequest.serializeBinaryToWriter = function(message, writer) {
  var f = undefined;
  f = message.getYear();
  if (f !== 0) {
    writer.writeInt32(
      1,
      f
    );
  }
  f = message.getState();
  if (f.length > 0) {
    writer.writeString(
      2,
      f
    );
  }
  f = message.getType();
  if (f.length > 0) {
    writer.writeString(
      3,
      f
    );
  }
  f = message.getLength();
  if (f.length > 0) {
    writer.writeString(
      4,
      f
    );
  }
  f = message.getExpense();
  if (f !== 0) {
    writer.writeInt32(
      5,
      f
    );
  }
};


/**
 * optional int32 year = 1;
 * @return {number}
 */
proto.edu_cost_stat.QueryOneRequest.prototype.getYear = function() {
  return /** @type {number} */ (jspb.Message.getFieldWithDefault(this, 1, 0));
};


/**
 * @param {number} value
 * @return {!proto.edu_cost_stat.QueryOneRequest} returns this
 */
proto.edu_cost_stat.QueryOneRequest.prototype.setYear = function(value) {
  return jspb.Message.setProto3IntField(this, 1, value);
};


/**
 * optional string state = 2;
 * @return {string}
 */
proto.edu_cost_stat.QueryOneRequest.prototype.getState = function() {
  return /** @type {string} */ (jspb.Message.getFieldWithDefault(this, 2, ""));
};


/**
 * @param {string} value
 * @return {!proto.edu_cost_stat.QueryOneRequest} returns this
 */
proto.edu_cost_stat.QueryOneRequest.prototype.setState = function(value) {
  return jspb.Message.setProto3StringField(this, 2, value);
};


/**
 * optional string type = 3;
 * @return {string}
 */
proto.edu_cost_stat.QueryOneRequest.prototype.getType = function() {
  return /** @type {string} */ (jspb.Message.getFieldWithDefault(this, 3, ""));
};


/**
 * @param {string} value
 * @return {!proto.edu_cost_stat.QueryOneRequest} returns this
 */
proto.edu_cost_stat.QueryOneRequest.prototype.setType = function(value) {
  return jspb.Message.setProto3StringField(this, 3, value);
};


/**
 * optional string length = 4;
 * @return {string}
 */
proto.edu_cost_stat.QueryOneRequest.prototype.getLength = function() {
  return /** @type {string} */ (jspb.Message.getFieldWithDefault(this, 4, ""));
};


/**
 * @param {string} value
 * @return {!proto.edu_cost_stat.QueryOneRequest} returns this
 */
proto.edu_cost_stat.QueryOneRequest.prototype.setLength = function(value) {
  return jspb.Message.setProto3StringField(this, 4, value);
};


/**
 * optional int32 expense = 5;
 * @return {number}
 */
proto.edu_cost_stat.QueryOneRequest.prototype.getExpense = function() {
  return /** @type {number} */ (jspb.Message.getFieldWithDefault(this, 5, 0));
};


/**
 * @param {number} value
 * @return {!proto.edu_cost_stat.QueryOneRequest} returns this
 */
proto.edu_cost_stat.QueryOneRequest.prototype.setExpense = function(value) {
  return jspb.Message.setProto3IntField(this, 5, value);
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
proto.edu_cost_stat.QueryOneResponse.prototype.toObject = function(opt_includeInstance) {
  return proto.edu_cost_stat.QueryOneResponse.toObject(opt_includeInstance, this);
};


/**
 * Static version of the {@see toObject} method.
 * @param {boolean|undefined} includeInstance Deprecated. Whether to include
 *     the JSPB instance for transitional soy proto support:
 *     http://goto/soy-param-migration
 * @param {!proto.edu_cost_stat.QueryOneResponse} msg The msg instance to transform.
 * @return {!Object}
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.edu_cost_stat.QueryOneResponse.toObject = function(includeInstance, msg) {
  var f, obj = {
    year: jspb.Message.getFieldWithDefault(msg, 1, 0),
    state: jspb.Message.getFieldWithDefault(msg, 2, ""),
    type: jspb.Message.getFieldWithDefault(msg, 3, ""),
    length: jspb.Message.getFieldWithDefault(msg, 4, ""),
    expense: jspb.Message.getFieldWithDefault(msg, 5, 0),
    cost: jspb.Message.getFloatingPointFieldWithDefault(msg, 6, 0.0)
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
 * @return {!proto.edu_cost_stat.QueryOneResponse}
 */
proto.edu_cost_stat.QueryOneResponse.deserializeBinary = function(bytes) {
  var reader = new jspb.BinaryReader(bytes);
  var msg = new proto.edu_cost_stat.QueryOneResponse;
  return proto.edu_cost_stat.QueryOneResponse.deserializeBinaryFromReader(msg, reader);
};


/**
 * Deserializes binary data (in protobuf wire format) from the
 * given reader into the given message object.
 * @param {!proto.edu_cost_stat.QueryOneResponse} msg The message object to deserialize into.
 * @param {!jspb.BinaryReader} reader The BinaryReader to use.
 * @return {!proto.edu_cost_stat.QueryOneResponse}
 */
proto.edu_cost_stat.QueryOneResponse.deserializeBinaryFromReader = function(msg, reader) {
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
      msg.setState(value);
      break;
    case 3:
      var value = /** @type {string} */ (reader.readString());
      msg.setType(value);
      break;
    case 4:
      var value = /** @type {string} */ (reader.readString());
      msg.setLength(value);
      break;
    case 5:
      var value = /** @type {number} */ (reader.readInt32());
      msg.setExpense(value);
      break;
    case 6:
      var value = /** @type {number} */ (reader.readDouble());
      msg.setCost(value);
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
proto.edu_cost_stat.QueryOneResponse.prototype.serializeBinary = function() {
  var writer = new jspb.BinaryWriter();
  proto.edu_cost_stat.QueryOneResponse.serializeBinaryToWriter(this, writer);
  return writer.getResultBuffer();
};


/**
 * Serializes the given message to binary data (in protobuf wire
 * format), writing to the given BinaryWriter.
 * @param {!proto.edu_cost_stat.QueryOneResponse} message
 * @param {!jspb.BinaryWriter} writer
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.edu_cost_stat.QueryOneResponse.serializeBinaryToWriter = function(message, writer) {
  var f = undefined;
  f = message.getYear();
  if (f !== 0) {
    writer.writeInt32(
      1,
      f
    );
  }
  f = message.getState();
  if (f.length > 0) {
    writer.writeString(
      2,
      f
    );
  }
  f = message.getType();
  if (f.length > 0) {
    writer.writeString(
      3,
      f
    );
  }
  f = message.getLength();
  if (f.length > 0) {
    writer.writeString(
      4,
      f
    );
  }
  f = message.getExpense();
  if (f !== 0) {
    writer.writeInt32(
      5,
      f
    );
  }
  f = message.getCost();
  if (f !== 0.0) {
    writer.writeDouble(
      6,
      f
    );
  }
};


/**
 * optional int32 year = 1;
 * @return {number}
 */
proto.edu_cost_stat.QueryOneResponse.prototype.getYear = function() {
  return /** @type {number} */ (jspb.Message.getFieldWithDefault(this, 1, 0));
};


/**
 * @param {number} value
 * @return {!proto.edu_cost_stat.QueryOneResponse} returns this
 */
proto.edu_cost_stat.QueryOneResponse.prototype.setYear = function(value) {
  return jspb.Message.setProto3IntField(this, 1, value);
};


/**
 * optional string state = 2;
 * @return {string}
 */
proto.edu_cost_stat.QueryOneResponse.prototype.getState = function() {
  return /** @type {string} */ (jspb.Message.getFieldWithDefault(this, 2, ""));
};


/**
 * @param {string} value
 * @return {!proto.edu_cost_stat.QueryOneResponse} returns this
 */
proto.edu_cost_stat.QueryOneResponse.prototype.setState = function(value) {
  return jspb.Message.setProto3StringField(this, 2, value);
};


/**
 * optional string type = 3;
 * @return {string}
 */
proto.edu_cost_stat.QueryOneResponse.prototype.getType = function() {
  return /** @type {string} */ (jspb.Message.getFieldWithDefault(this, 3, ""));
};


/**
 * @param {string} value
 * @return {!proto.edu_cost_stat.QueryOneResponse} returns this
 */
proto.edu_cost_stat.QueryOneResponse.prototype.setType = function(value) {
  return jspb.Message.setProto3StringField(this, 3, value);
};


/**
 * optional string length = 4;
 * @return {string}
 */
proto.edu_cost_stat.QueryOneResponse.prototype.getLength = function() {
  return /** @type {string} */ (jspb.Message.getFieldWithDefault(this, 4, ""));
};


/**
 * @param {string} value
 * @return {!proto.edu_cost_stat.QueryOneResponse} returns this
 */
proto.edu_cost_stat.QueryOneResponse.prototype.setLength = function(value) {
  return jspb.Message.setProto3StringField(this, 4, value);
};


/**
 * optional int32 expense = 5;
 * @return {number}
 */
proto.edu_cost_stat.QueryOneResponse.prototype.getExpense = function() {
  return /** @type {number} */ (jspb.Message.getFieldWithDefault(this, 5, 0));
};


/**
 * @param {number} value
 * @return {!proto.edu_cost_stat.QueryOneResponse} returns this
 */
proto.edu_cost_stat.QueryOneResponse.prototype.setExpense = function(value) {
  return jspb.Message.setProto3IntField(this, 5, value);
};


/**
 * optional double cost = 6;
 * @return {number}
 */
proto.edu_cost_stat.QueryOneResponse.prototype.getCost = function() {
  return /** @type {number} */ (jspb.Message.getFloatingPointFieldWithDefault(this, 6, 0.0));
};


/**
 * @param {number} value
 * @return {!proto.edu_cost_stat.QueryOneResponse} returns this
 */
proto.edu_cost_stat.QueryOneResponse.prototype.setCost = function(value) {
  return jspb.Message.setProto3FloatField(this, 6, value);
};


goog.object.extend(exports, proto.edu_cost_stat);
